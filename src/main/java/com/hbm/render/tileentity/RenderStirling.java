package com.hbm.render.tileentity;

import org.lwjgl.opengl.GL11;

import com.hbm.blocks.BlockDummyable;
import com.hbm.blocks.ModBlocks;
import com.hbm.main.ResourceManager;
import com.hbm.render.item.ItemRenderBase;
import com.hbm.tileentity.machine.TileEntityStirling;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class RenderStirling extends TileEntitySpecialRenderer implements IItemRendererProvider {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float interp) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y, z + 0.5D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		
		switch(tile.getBlockMetadata() - BlockDummyable.offset) {
		case 3: GL11.glRotatef(0, 0F, 1F, 0F); break;
		case 5: GL11.glRotatef(90, 0F, 1F, 0F); break;
		case 2: GL11.glRotatef(180, 0F, 1F, 0F); break;
		case 4: GL11.glRotatef(270, 0F, 1F, 0F); break;
		}
		
		TileEntityStirling stirling = (TileEntityStirling) tile;
		
		float rot = stirling.lastSpin + (stirling.spin - stirling.lastSpin) * interp;
		renderCommon(rot, stirling.hasCog, stirling.getGeatMeta());
		
		GL11.glPopMatrix();
	}
	
	private void renderCommon(float rot, boolean hasCog, int type) {

		if(type == 0)
			bindTexture(ResourceManager.stirling_tex);
		else
			bindTexture(ResourceManager.stirling_steel_tex);
		
		ResourceManager.stirling.renderPart("Base");

		if(hasCog) {
			GL11.glPushMatrix();
			GL11.glTranslated(0, 1.375, 0);
			GL11.glRotatef(-rot, 0, 0, 1);
			GL11.glTranslated(0, -1.375, 0);
			ResourceManager.stirling.renderPart("Cog");
			GL11.glPopMatrix();
		}
		
		GL11.glPushMatrix();
		GL11.glTranslated(0, 1.375, 0.25);
		GL11.glRotatef(rot * 2 + 3, 1, 0, 0);
		GL11.glTranslated(0, -1.375, -0.25);
		ResourceManager.stirling.renderPart("CogSmall");
		GL11.glPopMatrix();
		
		GL11.glTranslated(Math.sin(rot * Math.PI / 90D) * 0.25 + 0.125, 0, 0);
		ResourceManager.stirling.renderPart("Piston");
	}

	@Override
	public Item getItemForRenderer() {
		return Item.getItemFromBlock(ModBlocks.machine_stirling);
	}

	@Override
	public Item[] getItemsForRenderer() {
		return new Item[] {
				Item.getItemFromBlock(ModBlocks.machine_stirling),
				Item.getItemFromBlock(ModBlocks.machine_stirling_steel)
		};
	}

	@Override
	public IItemRenderer getRenderer() {
		return new ItemRenderBase( ) {
			public void renderInventory() {
				GL11.glTranslated(0, -1.5, 0);
				GL11.glScaled(3.25, 3.25, 3.25);
			}
			public void renderCommonWithStack(ItemStack item) {
				GL11.glRotatef(90, 0F, 1F, 0F);
				boolean cog = item.getItemDamage() != 1;
				RenderStirling.this.renderCommon(cog ? System.currentTimeMillis() % 3600 * 0.1F : 0, cog, item.getItem() == Item.getItemFromBlock(ModBlocks.machine_stirling) ? 0 : 1);
			}};
	}
}
