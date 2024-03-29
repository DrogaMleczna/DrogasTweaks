package com.drogamleczna.drogastweaks.entity.ai;

import com.drogamleczna.drogastweaks.entity.custom.ScorpionEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class ScorpionAttackGoal extends MeleeAttackGoal {

    private final ScorpionEntity entity;
    private float attackDelay = 0.5f;
    private float secsUntilNextAttack = 0.75f;
    private boolean shouldCountTillNextAttack = false;
    public ScorpionAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((ScorpionEntity) pMob);
    }


    @Override
    public void start() {
        super.start();
        attackDelay = 0.5f;
        secsUntilNextAttack = 0.75f;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.secsUntilNextAttack = 1.25f;
    }

    protected boolean isTimeToAttack() {
        return this.secsUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.secsUntilNextAttack <= attackDelay;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
        pEnemy.addEffect(new MobEffectInstance(MobEffects.POISON, 60));
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.secsUntilNextAttack = Math.max(this.secsUntilNextAttack - 0.1f, 0); //Certified WTF behaviour, should use tics, but uses seconds instead
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}