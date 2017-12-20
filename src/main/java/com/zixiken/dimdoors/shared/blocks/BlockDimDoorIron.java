package com.zixiken.dimdoors.shared.blocks;

import com.zixiken.dimdoors.DimDoors;
import com.zixiken.dimdoors.shared.items.ModItems;
import com.zixiken.dimdoors.shared.rifts.RiftDestination;
import com.zixiken.dimdoors.shared.tileentities.TileEntityEntranceRift;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockDimDoorIron extends BlockDimDoorBase {

    public static final String ID = "dimensional_door";

    public BlockDimDoorIron() {
        super(Material.IRON);
        setHardness(1.0F);
        setResistance(2000.0F);
        setUnlocalizedName(ID);
        setRegistryName(new ResourceLocation(DimDoors.MODID, ID));
    }

    @Override
    public Item getItem() {
        return ModItems.DIMENSIONAL_DOOR;
    }

    @Override
    protected void setupRift(TileEntityEntranceRift rift) {
        RiftDestination.NewPublicDestination destination = RiftDestination.NewPublicDestination.builder().build();
        rift.setSingleDestination(destination);
    }
}