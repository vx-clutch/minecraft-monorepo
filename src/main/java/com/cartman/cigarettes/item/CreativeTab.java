package com.cartman.cigarettes.item;

import com.cartman.cigarettes.Cigarettes;
import com.cartman.cigarettes.block.CBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cigarettes.MODID);

    public static final RegistryObject<CreativeModeTab> CIGARTAB = CREATIVE_MODE_TABS.register("cigartab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.CIGAR.get()))
                    .title(Component.translatable("creativetab.cigartab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.CIGAR.get());

                        pOutput.accept(CBlocks.FIVE_HUNDRED_CIGARETTES.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
