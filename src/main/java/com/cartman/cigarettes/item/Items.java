package com.cartman.cigarettes.item;

import com.cartman.cigarettes.Cigarettes;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cigarettes.MODID);

    public static final RegistryObject<Item> cigar = ITEMS.register("cigar",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus EventBus) {
        ITEMS.register(EventBus);
    }

}
