package com.drogamleczna.drogastweaks.entity.custom;

import com.drogamleczna.drogastweaks.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class SnailEntity extends Animal {
	public SnailEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	protected void updateWalkAnimation(float pPartialTick) {
		float f;
		if(this.getPose() == Pose.STANDING){f = Math.min(pPartialTick * 6f, 1f);}
		else{f = 0f;}
		this.walkAnimation.update(f, 0.2f);
	}

	@Override
	protected void registerGoals(){
		this.goalSelector.addGoal(0,new PanicGoal(this, 0.31D));
		this.goalSelector.addGoal(1,new FloatGoal(this));
		this.goalSelector.addGoal(2,new WaterAvoidingRandomStrollGoal(this, 0.3D));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

	}

	public static AttributeSupplier.Builder createAttributes(){
		return Animal.createLivingAttributes()
				.add(Attributes.MAX_HEALTH, 2D)
				.add(Attributes.MOVEMENT_SPEED, 0.2D)
				.add(Attributes.ARMOR, 1D)
				.add(Attributes.FOLLOW_RANGE, 24D);
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return null;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return ModSounds.SNAIL_DEATH.get();
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource pDamageSource) {
		return ModSounds.SNAIL_HURT.get();
	}

	public static boolean canSpawn(EntityType<SnailEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random){
		return checkAnimalSpawnRules(entityType, level, spawnType, position, random);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
		SpawnGroupData spawngroupdata = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
		return spawngroupdata;
	}
}