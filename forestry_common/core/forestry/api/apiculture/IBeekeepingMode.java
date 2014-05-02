/*******************************************************************************
 * Copyright 2011-2014 by SirSengir
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/.
 ******************************************************************************/
package forestry.api.apiculture;

import java.util.ArrayList;

import net.minecraft.world.World;

public interface IBeekeepingMode extends IBeeModifier {

	/**
	 * @return Localized name of this beekeeping mode.
	 */
	String getName();

	/**
	 * @return Localized list of strings outlining the behaviour of this beekeeping mode.
	 */
	ArrayList<String> getDescription();

	/**
	 * @return Float used to modify the wear on comb frames.
	 */
	float getWearModifier();

	/**
	 * @param queen
	 * @return fertility taking into account the birthing queen and surroundings.
	 */
	int getFinalFertility(IBee queen, World world, int x, int y, int z);

	/**
	 * @param queen
	 * @return true if the queen is genetically "fatigued" and should not be reproduced anymore.
	 */
	boolean isFatigued(IBee queen, IBeeHousing housing);

	/**
	 * @param queen
	 * @param housing
	 * @return true if the queen is being overworked in the bee housing (with chance). will trigger a negative effect.
	 */
	boolean isOverworked(IBee queen, IBeeHousing housing);

	/**
	 * 
	 * @param queen
	 * @param offspring
	 * @param housing
	 * @return true if the genetic structure of the queen is breaking down during spawning of the offspring (with chance). will trigger a negative effect.
	 */
	boolean isDegenerating(IBee queen, IBee offspring, IBeeHousing housing);

	/**
	 * @param queen
	 * @return true if an offspring of this queen is considered a natural
	 */
	boolean isNaturalOffspring(IBee queen);

	/**
	 * @param queen
	 * @return true if this mode allows the passed queen or princess to be multiplied
	 */
	boolean mayMultiplyPrincess(IBee queen);


}
