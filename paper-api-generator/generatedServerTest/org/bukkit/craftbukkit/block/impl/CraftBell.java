package org.bukkit.craftbukkit.block.impl;

import com.google.common.base.Preconditions;
import io.papermc.paper.generated.GeneratedFrom;
import java.util.Set;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bell;
import org.bukkit.craftbukkit.block.data.CraftBlockData;

@GeneratedFrom("1.20.6")
@SuppressWarnings("unused")
public class CraftBell extends CraftBlockData implements Bell {
    private static final EnumProperty<BellAttachType> ATTACHMENT = BellBlock.ATTACHMENT;

    private static final DirectionProperty FACING = BellBlock.FACING;

    private static final BooleanProperty POWERED = BellBlock.POWERED;

    public CraftBell(BlockState state) {
        super(state);
    }

    @Override
    public Bell.Attachment getAttachment() {
        return this.get(ATTACHMENT, Bell.Attachment.class);
    }

    @Override
    public void setAttachment(final Bell.Attachment attachment) {
        Preconditions.checkArgument(attachment != null, "attachment cannot be null!");
        this.set(ATTACHMENT, attachment);
    }

    @Override
    public BlockFace getFacing() {
        return this.get(FACING, BlockFace.class);
    }

    @Override
    public void setFacing(final BlockFace blockFace) {
        Preconditions.checkArgument(blockFace != null, "blockFace cannot be null!");
        Preconditions.checkArgument(blockFace.isCartesian() && blockFace.getModY() == 0, "Invalid face, only cartesian horizontal face are allowed for this property!");
        this.set(FACING, blockFace);
    }

    @Override
    public Set<BlockFace> getFaces() {
        return this.getValues(FACING, BlockFace.class);
    }

    @Override
    public boolean isPowered() {
        return this.get(POWERED);
    }

    @Override
    public void setPowered(final boolean powered) {
        this.set(POWERED, powered);
    }
}
