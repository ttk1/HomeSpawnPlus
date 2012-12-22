/**
 * 
 */
package org.morganm.homespawnplus.server.bukkit.events;

import org.morganm.homespawnplus.server.api.Location;
import org.morganm.homespawnplus.server.bukkit.BukkitFactory;
import org.morganm.homespawnplus.server.bukkit.BukkitLocation;


/**
 * @author morganm
 *
 */
public class PlayerRespawnEvent extends PlayerEvent
implements org.morganm.homespawnplus.server.api.events.PlayerRespawnEvent
{
    private org.bukkit.event.player.PlayerRespawnEvent event;

    public PlayerRespawnEvent(org.bukkit.event.player.PlayerRespawnEvent event, BukkitFactory bukkitFactory) {
        super(event, bukkitFactory);
        this.event = event;
    }

    @Override
    public void setRespawnLocation(Location respawnLocation) {
        event.setRespawnLocation(new BukkitLocation(respawnLocation).getBukkitLocation());
    }

    @Override
    public boolean isBedSpawn() {
        return event.isBedSpawn();
    }

    @Override
    public Location getRespawnLocation() {
        return new BukkitLocation(event.getRespawnLocation());
    }
}
