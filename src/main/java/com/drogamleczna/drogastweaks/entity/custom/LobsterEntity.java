package com.drogamleczna.drogastweaks.entity.custom;

import com.drogamleczna.drogastweaks.entity.ModEntities;
import com.drogamleczna.drogastweaks.entity.variant.LobsterVariant;
import com.drogamleczna.drogastweaks.item.ModItems;
import com.drogamleczna.drogastweaks.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

public class LobsterEntity extends Animal implements Bucketable {
    public LobsterEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(LobsterEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(LobsterEntity.class, EntityDataSerializers.BOOLEAN);
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

    public boolean canRandomSwim() {
        return true;
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){f = Math.min(pPartialTick * 6f, 1f);}
        else{f = 0f;}

        this.walkAnimation.update(f, 0.2f);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }


    public boolean isPushedByFluid() {
        return false;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(0,new PanicGoal(this, 1.15D));
        this.goalSelector.addGoal(1, new BreedGoal(this,1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this,1.0D, Ingredient.of(Items.COD), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this,1.0D));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1D, 1));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 7D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.ARMOR, 2D);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.LOBSTER.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.FISHES) || pStack.is(ModItems.CRAB_LEG.get());
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.LOBSTER_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.LOBSTER_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.LOBSTER_HURT.get();
    }

    @Override
    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag){
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag){
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    public static boolean canSpawn(EntityType<LobsterEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random){
        return checkLobsterSpawnRules(entityType, level, spawnType, position, random);
    }


    public static boolean checkLobsterSpawnRules(EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.getBlockState(pPos.below()).is(Blocks.SAND) || pLevel.getBlockState(pPos.below()).is(Blocks.GRAVEL) || pLevel.getBlockState(pPos.below()).is(Blocks.WATER);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason,
                                        @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        if (pLevel.getBiome(this.blockPosition()).is(Biomes.WARM_OCEAN)) {
            setVariant(LobsterVariant.BLUE);
        }else{
            setVariant(LobsterVariant.DEFAULT);
        }

        //LobsterVariant variant = Util.getRandom(LobsterVariant.values(), this.random);
        //setVariant(variant);
        SpawnGroupData spawngroupdata = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        return spawngroupdata;
    }
    /* VARIANTS */

    public LobsterVariant getVariant() {
        return LobsterVariant.byId(this.getTypeVariant() & 255);
    }



    private int getTypeVariant(){
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(LobsterVariant variant){
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean pFromBucket) {
        this.entityData.set(FROM_BUCKET, pFromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack pStack) {
        Bucketable.saveDefaultDataToBucketTag(this, pStack);
        CompoundTag compoundtag = pStack.getOrCreateTag();
        compoundtag.putInt("Variant", this.getVariant().getId());
        compoundtag.putInt("Age", this.getAge());

    }

    @Override
    public void loadFromBucketTag(CompoundTag pTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, pTag);
        this.setVariant(LobsterVariant.byId(pTag.getInt("Variant")));
        if (pTag.contains("Age")) {
            this.setAge(pTag.getInt("Age"));
        }

    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.LOBSTER_BUCKET.get());
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_AXOLOTL;
    }
}

