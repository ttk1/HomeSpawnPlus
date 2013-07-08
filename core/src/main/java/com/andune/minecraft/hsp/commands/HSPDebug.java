/**
 * 
 */
package com.andune.minecraft.hsp.commands;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import javax.inject.Inject;

import com.andune.minecraft.commonlib.server.api.CommandSender;
import com.andune.minecraft.hsp.HSPMessages;
import com.andune.minecraft.hsp.command.BaseCommand;
import com.andune.minecraft.hsp.commands.uber.UberCommand;
import com.andune.minecraft.hsp.config.ConfigCore;

/**
 * @author andune
 *
 */
@UberCommand(uberCommand="hsp", subCommand="debug", help="HSP debug commands")
public class HSPDebug extends BaseCommand {
	@Inject ConfigCore configCore;
	
    private boolean rootHandlerInstalled = false;

	@Override
	public String getUsage() {
		return server.getLocalizedMessage(HSPMessages.CMD_HSPDEBUG_USAGE);
	}

    @Override
    public boolean execute(final CommandSender sender, String cmd, String[] args) {
        if( !permissions.isAdmin(sender) )
			return false;
		
		if( args.length < 1 ) {
			return false;
		}
		else if( args[0].startsWith("t") ) {	// toggle debug mode
			boolean current = configCore.isDebug();
			configCore.setDebug(!current);
			sender.sendMessage("HSP DEBUG flag toggled to "+!current);
		}
		else if( args[0].startsWith("log") ) {
			java.util.logging.Logger log = java.util.logging.Logger.getLogger("Minecraft");
			java.util.logging.Logger rootLog = java.util.logging.Logger.getLogger("");
			
			if( !rootHandlerInstalled ) {
				try {
					java.util.logging.Handler handler = new java.util.logging.FileHandler("server_full.log");
					handler.setLevel(Level.FINEST);
					// do some smart filtering of messages later
					java.util.logging.Formatter formatter = new java.util.logging.Formatter() {
						@Override
						public String format(LogRecord record) {
							StringBuffer s = new StringBuffer();
							s.append("[");
							s.append(record.getLevel().toString());
							s.append("] ");
							s.append("[");
							s.append(record.getSourceClassName());
							s.append("] ");
							
							s.append(super.formatMessage(record));
							return s.toString();
						}
					};
					handler.setFormatter(formatter);
					
					// install new handler
					rootLog.addHandler(handler);

					rootHandlerInstalled = true;
				}
				catch(java.io.IOException e) {}
			}
			
			try {
				java.util.logging.Logger ebeansLogger = java.util.logging.Logger.getLogger("com.avaje");
				java.util.logging.Handler handler = new java.util.logging.FileHandler("ebean.log");
				handler.setLevel(Level.SEVERE);
				// do some smart filtering of messages later
				java.util.logging.Formatter formatter = new java.util.logging.Formatter() {
					@Override
					public String format(LogRecord record) {
						return super.formatMessage(record);
					}
				};
				handler.setFormatter(formatter);
				
				// cleanup any old handlers first
				java.util.logging.Handler[] handlers = ebeansLogger.getHandlers();
				for(java.util.logging.Handler h : handlers) {
					ebeansLogger.removeHandler(h);
				}
				
				// install new handler
				ebeansLogger.addHandler(handler);
			}
			catch(java.io.IOException e) {}

			sender.sendMessage("Minecraft logger Handlers:");
			java.util.logging.Handler[] handlers = log.getHandlers();
			for(java.util.logging.Handler handler : handlers) {
				sender.sendMessage("  Handler: "+handler);
			}
			
			sender.sendMessage("Root Handlers:");
			handlers = rootLog.getHandlers();
			for(java.util.logging.Handler handler : handlers) {
				sender.sendMessage("  Handler: "+handler);
				java.util.logging.Formatter formatter = handler.getFormatter();
				sender.sendMessage("  Formatter: "+formatter);
			}
			
			return true;
		}
		else if( args[0].startsWith("eb") ) {	// ebeans cache stats
		}
		else {
			return false;
		}

		return true;
    }
}