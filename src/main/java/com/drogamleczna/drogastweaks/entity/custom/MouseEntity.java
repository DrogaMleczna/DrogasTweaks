package com.drogamleczna.drogastweaks.entity.custom;

import com.drogamleczna.drogastweaks.entity.ModEntities;
import com.drogamleczna.drogastweaks.sound.ModSounds;
import net.minecraft.client.sounds.SoundEngineExecutor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import org.jetbrains.annotations.Nullable;

public class MouseEntity extends Animal {
    public MouseEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide()){
            setupAnimationStates();
        }
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }else{--this.idleAnimationTimeout;}
    }


    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){f = Math.min(pPartialTick * 6f, 1f);}
        else{f = 0f;}

        this.walkAnimation.update(f, 0.2f);
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public boolean isPushedByFluid() {
        return true;
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(0,new FloatGoal(this));
        this.goalSelector.addGoal(1,new PanicGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new BreedGoal(this,1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this,1.0D, Ingredient.of(Items.COD), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this,1.0D));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 3D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.MOUSE.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.WHEAT_SEEDS);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.MOUSE_SQUEAK.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.MOUSE_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.MOUSE_HURT.get();
    }

    public static boolean canSpawn(EntityType<MouseEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random){
        return checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }


    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        return spawngroupdata;
    }
}