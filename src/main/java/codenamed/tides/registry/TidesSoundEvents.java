package codenamed.tides.registry;

import codenamed.tides.Tides;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class TidesSoundEvents {


    public  static SoundEvent CLAM_OPEN = registerSoundEvent("clam_open");
    public  static SoundEvent CLAM_CLOSE = registerSoundEvent("clam_close");

    public  static  SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Tides.MOD_ID, name);
        SoundEvent soundEvent = SoundEvent.of(id);

        Registry.register(Registries.SOUND_EVENT, id, soundEvent);

        return soundEvent;
    }

    public  static  void  init() { }
}
