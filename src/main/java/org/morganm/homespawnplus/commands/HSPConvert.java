/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (c) 2012 Mark Morgan.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * Contributors:
 *     Mark Morgan - initial API and implementation
 ******************************************************************************/
/**
 * 
 */
package org.morganm.homespawnplus.commands;

import javax.inject.Inject;

import org.morganm.homespawnplus.command.BaseCommand;
import org.morganm.homespawnplus.convert.CommandBook;
import org.morganm.homespawnplus.convert.Converter;
import org.morganm.homespawnplus.convert.Essentials29;
import org.morganm.homespawnplus.convert.SpawnControl;
import org.morganm.homespawnplus.server.api.CommandSender;
import org.morganm.homespawnplus.server.api.Scheduler;

import com.google.inject.Injector;

/**
 * @author morganm
 *
 */
public class HSPConvert extends BaseCommand {
    @Inject private Injector injector;
    @Inject private Scheduler scheduler;

    public boolean execute(CommandSender sender, String[] args) {
        if( permissions.isAdmin(sender) )
            return false;
		
		Converter converter = null;
		
		if( args.length < 1 ) {
			sender.sendMessage("Usage: /"+getCommandName()+" [essentials|spawncontrol|commandbook]");
		}
		else if( args[0].equalsIgnoreCase("commandbook") ) {
			converter = injector.getInstance(CommandBook.class);
		}
		else if( args[0].equalsIgnoreCase("essentials") ) {
            converter = injector.getInstance(Essentials29.class);
		}
		else if( args[0].equalsIgnoreCase("spawncontrol") ) {
            converter = injector.getInstance(SpawnControl.class);
		}
		else {
			sender.sendMessage("Unknown conversion type: "+args[0]);
		}
		
		if( converter != null ) {
		    converter.setInitiatingSender(sender);
            sender.sendMessage("Starting "+converter.getConverterName()+" conversion");
			scheduler.scheduleAsyncDelayedTask(converter, 0L);
		}
		
		return true;
	}

}
