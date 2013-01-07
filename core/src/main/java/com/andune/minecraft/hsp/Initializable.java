/**
 * 
 */
package com.andune.minecraft.hsp;

/**
 * Interface for classes to implement if they need initialization
 * on plugin startup.
 * 
 * Any class under org.morganm.homespawnplus implementing this
 * interface will be automatically picked up and initialized after
 * IoC injection is finished. 
 * 
 * @author morganm
 *
 */
public interface Initializable {
    /**
     * This method is invoked when it is time to initialize and
     * should do whatever this object needs done to become ready
     * for use.
     * 
     * @throws Exception any thrown Exception will stop the
     * entire initialization process.
     */
    public void init() throws Exception;

    /**
     * That which can be started up can also be shutdown. This
     * is called when the plugin is disabled so the object can
     * do any necessary cleanup.
     * 
     * @throws Exception any thrown Exception will be printed
     * to the console and then ignored
     */
    public void shutdown() throws Exception;

    /**
     * Initialization priority, this should be a number where
     * 0 is the highest priority. Negative numbers are equivalent
     * to 0. Objects are loaded in order of priority.
     * 
     * Recommended values:
     * 0-4 reserved for Config objects
     * 5-9 reserved for ordered early initialization objects
     * 10+ general use priority
     * 
     * @return
     */
    public int getInitPriority();
}