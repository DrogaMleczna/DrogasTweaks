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

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(DrogasTweaks.MOD_ID, name);
        return  SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
