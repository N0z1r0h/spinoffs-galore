package n0z1r0h.spinoff_galore.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;

public class Cluckshroom extends ChickenEntity implements GeoEntity, Shearable {
    public Cluckshroom(EntityType<? extends ChickenEntity> entityType, World world) {
        super(entityType, world);
        this.eggLayTime = this.random.nextInt(6000) + 6000;
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    public void initgoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new AnimalMateGoal(this, (double)1.0F));
        this.goalSelector.add(3, new TemptGoal(this, (double)1.0F, (stack) -> stack.isIn(ItemTags.CHICKEN_FOOD), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, (double)1.0F));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }

    @Override
    public void sheared(ServerWorld world, SoundCategory shearedSoundCategory, ItemStack shears) {

    }

    @Override
    public boolean isShearable() {
        return this.isAlive() && !this.isBaby();
    }
}
