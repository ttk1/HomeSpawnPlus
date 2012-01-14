/**
 * 
 */
package org.morganm.homespawnplus.i18n;

/** This is the only class in this package specific to HSP. Just provide your
 * own and use it in your own implementation.
 * 
 * @author morganm
 *
 */
public enum HSPMessages {
	HOME_BED_SET,
	HOME_BED_ONE_MORE_CLICK,
	
	CMD_HOME_NO_OTHERWORLD_PERMISSION,
	CMD_HOME_NO_HOME_ON_WORLD,
	CMD_HOME_NO_NAMED_HOME_PERMISSION,
	CMD_HOME_NO_NAMED_HOME_FOUND,
	NO_HOME_FOUND,
	
	CMD_SETHOME_NO_USE_RESERVED_NAME,
	CMD_SETHOME_NO_NAMED_HOME_PERMISSION,
	CMD_SETHOME_HOME_SET,
	CMD_SETHOME_DEFAULT_HOME_SET,
	
	CMD_SPAWN_NO_SPAWN_FOUND,
	
	CMD_GROUPSPAWN_NO_GROUPSPAWN_FOR_GROUP,
	
	CMD_HOMEDELETE_ERROR_DELETING_OTHER_HOME,
	CMD_HOMEDELETE_HOME_DELETED,
	CMD_HOMEDELETE_DEFAULT_HOME_DELETED,
	CMD_HOMEDELETE_NO_HOME_FOUND,
	CMD_HOMEDELETE_NO_DEFAULT_HOME_FOUND,

	CMD_HOMEDELETEOTHER_HOME_DELETED,
	CMD_HOMEDELETEOTHER_DEFAULT_HOME_DELETED,
	CMD_HOMEDELETEOTHER_NO_HOME_FOUND,
	CMD_HOMEDELETEOTHER_NO_DEFAULT_HOME_FOUND,
	
	CMD_HOMELIST_ALL_WORLDS,
	CMD_HOMELIST_FOR_WORLD,
	CMD_HOMELIST_NO_HOMES_FOUND,
	
	CMD_HOMEOTHER_TELEPORTING,
	
	CMD_SETDEFAULTHOME_SPECIFY_HOMENAME,
	CMD_SETDEFAULTHOME_HOME_CHANGED,
	
	CMD_SETDEFAULTSPAWN_SPECIFY_NAME,
	CMD_SETDEFAULTSPAWN_SPAWN_CHANGED,
	
	CMD_SETFIRSTSPAWN_SET,
	
	CMD_SETHOMEOTHER_HOME_SET,
	CMD_SETHOMEOTHER_DEFAULT_HOME_SET,
	
	CMD_SETSPAWN_SET_NAMED_SUCCESS,
	CMD_SETSPAWN_SET_SUCCESS,
	
	CMD_SPAWNDELETE_NO_SPAWN_FOUND,
	CMD_SPAWNDELETE_SPAWN_DELETED,
	
	CMD_SPAWNLIST_ALL_WORLDS,
	CMD_SPAWNLIST_FOR_WORLD,
	CMD_SPAWNLIST_NO_SPAWNS_FOUND,

	CMD_WARMUP_FINISHED,
	
	CMD_HSP_ERROR_RELOADING,
	CMD_HSP_CONFIG_RELOADED,
	CMD_HSP_DATA_RELOADED,
	CMD_HSP_DATA_BACKED_UP,
	CMD_HSP_DATA_BACKUP_ERROR,
	CMD_HSP_DATA_RESTORE_USAGE,
	CMD_HSP_DATA_RESTORE_SUCCESS,
	CMD_HSP_DATA_RESTORE_NO_FILE,
	
	WARMUP_STARTED,
	WARMUP_ALREADY_PENDING,
	WARMUP_CANCELLED_DAMAGE,
	WARMUP_CANCELLED_YOU_MOVED,
	
	COOLDOWN_IN_EFFECT,
	
	COST_CHARGED,
	COST_ERROR,
	COST_INSUFFICIENT_FUNDS,
	
	NO_PERMISSION,
	TOO_MANY_ARGUMENTS,
	
	GENERIC_NAME,
	GENERIC_GROUP,
	GENERIC_DEFAULT,
	GENERIC_WORLD_DEFAULT,
}