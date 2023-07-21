package com.store.backendStore.persistence.mapper;

import com.store.backendStore.domain.Purchase;
import com.store.backendStore.domain.PurchaseItem;
import com.store.backendStore.persistence.entity.Compra;
import com.store.backendStore.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "comprasProductoList", target = "purchaseItems")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchaseList(List<Compra> comprasList);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
