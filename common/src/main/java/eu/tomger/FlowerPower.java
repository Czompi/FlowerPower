package eu.tomger;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class FlowerPower {
    public static final String MOD_ID = "flower_power";
    // We can use this if we don't want to use DeferredRegister
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> MY_TAB = TABS.register(
            "test_tab", // Tab ID
            () -> CreativeTabRegistry.create(
                    Component.translatable(MOD_ID), // Tab Name
                    () -> new ItemStack(EXAMPLE_ITEM.get().asItem()) // Icon
            )
    );
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("flower_power_item", () ->
            new Item(new Item.Properties().tab(FlowerPower.EXAMPLE_TAB)));
    
    public static void init() {
        ITEMS.register();
        
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
