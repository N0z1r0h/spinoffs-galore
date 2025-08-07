package n0z1r0h.spinoff_galore.Registry;

import n0z1r0h.spinoff_galore.SpinoffsGalore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EntityRegistry {
    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(SpinoffsGalore.MOD_ID, name));
        return Registry.register(Registries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void init() {
        SpinoffsGalore.LOGGER.info("Attempting \"REGISTRATION\" of EntityTypes for mod: " + SpinoffsGalore.MOD_ID);
    }
}
