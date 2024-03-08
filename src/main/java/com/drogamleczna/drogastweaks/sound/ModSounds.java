package com.drogamleczna.drogastweaks.sound;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public  static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DrogasTweaks.MOD_ID);

    public static final RegistryObject<SoundEvent> OWL_HOOT = registerSoundEvent("owl_hoot");
    public static final RegistryObject<SoundEvent> OWL_DEATH = registerSoundEvent("owl_death");
    public static final RegistryObject<SoundEvent> OWL_HURT = registerSoundEvent("owl_hurt");
    public static final RegistryObject<SoundEvent> MOUSE_SQUEAK = registerSoundEvent("mouse_squeak");
    public static final RegistryObject<SoundEvent> MOUSE_HURT = registerSoundEvent("mouse_hurt");
    public static final RegistryObject<SoundEvent> MOUSE_DEATH = registerSoundEvent("mouse_death");
    public static final RegistryObject<SoundEvent> LOBSTER_AMBIENT = registerSoundEvent("lobster_ambient");
    public static final RegistryObject<SoundEvent> LOBSTER_HURT = registerSoundEvent("lobster_hurt");
    public static final RegistryObject<SoundEvent> LOBSTER_DEATH = registerSoundEvent("lobster_death");
    public static final RegistryObject<SoundEvent> CRAB_AMBIENT = registerSoundEvent("crab_ambient");
    public static final RegistryObject<SoundEvent> CRAB_HURT = registerSoundEvent("crab_hurt");
    public static final RegistryObject<SoundEvent> CRAB_DEATH = registerSoundEvent("crab_death");
    public static final RegistryObject<SoundEvent> SCORPION_AMBIENT = registerSoundEvent("scorpion_ambient");
    public static final RegistryObject<SoundEvent> SCORPION_DEATH = registerSoundEvent("scorpion_death");
    public static final RegistryObject<SoundEvent> SCORPION_HURT = registerSoundEvent("scorpion_hurt");
    public static final RegistryObject<SoundEvent> SNAIL_HURT = registerSoundEvent("snail_hurt");
    public static final RegistryObject<SoundEvent> SNAIL_DEATH = registerSoundEvent("snail_death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(DrogasTweaks.MOD_ID, name);
        return  SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
