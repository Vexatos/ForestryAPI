/*******************************************************************************
 * Copyright 2011-2014 by SirSengir
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/.
 ******************************************************************************/
package forestry.api.arboriculture;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import forestry.api.genetics.IFruitFamily;

public interface IFruitProvider {

	IFruitFamily getFamily();

	int getColour(ITreeGenome genome, IBlockAccess world, int x, int y, int z, int ripeningTime);

	boolean markAsFruitLeaf(ITreeGenome genome, World world, int x, int y, int z);

	int getRipeningPeriod();

	// / Products, Chance
	ItemStack[] getProducts();

	// / Specialty, Chance
	ItemStack[] getSpecialty();

	ItemStack[] getFruits(ITreeGenome genome, World world, int x, int y, int z, int ripeningTime);

	/**
	 * @return Short, human-readable identifier used in the treealyzer.
	 */
	String getDescription();

	/* TEXTURE OVERLAY */
	/**
	 * @param genome
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param ripeningTime
	 *            Elapsed ripening time for the fruit.
	 * @param fancy
	 * @return IIcon index of the texture to overlay on the leaf block.
	 */
	short getIconIndex(ITreeGenome genome, IBlockAccess world, int x, int y, int z, int ripeningTime, boolean fancy);

	/**
	 * @return true if this fruit provider requires fruit blocks to spawn, false otherwise.
	 */
	boolean requiresFruitBlocks();

	/**
	 * Tries to spawn a fruit block at the potential position when the tree generates.
	 * 
	 * @param genome
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return true if a fruit block was spawned, false otherwise.
	 */
	boolean trySpawnFruitBlock(ITreeGenome genome, World world, int x, int y, int z);

	@SideOnly(Side.CLIENT)
	void registerIcons(IIconRegister register);
}
