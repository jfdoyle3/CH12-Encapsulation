package com.GroceryStore.konsole;

import com.GroceryStore.Store;

public class Spanish extends UI implements UserInterface {
    public Spanish(Store store) {
        super(store);
        MENU = new String[] {
                "1. agregar producto al inventario",
                "2. desechar un producto",
                "3. enumerar los productos disponibles",
                "4. vender un producto",
                "5. salir",
        };
        PRODUCT_TYPES = new String[] {
                "1. Bebida",
                "2. Fruta",
        };
        ERROR_MSGS =new String[] {
                "OK",
                "Número invalido",
                "excepción general",
                "Debe ingresar algo",
                "404 - Producto no encontrado"
        };
        PRODUCT_FIELDS = new String[] {"Nombre:", "precio:", "id:", "descripción:"};
        DRINK_FIELDS = new String[] {
                "Volumen:", "Código de unidad de volumen:"
        };
        FRUIT_FIELDS = new String[] {
                "Nivel de dureza:", "Es orgánico:"
        };
        WELCOME = "Bienvenido a ";
        MENU_PROMPT = "¿Qué queres hacer?";
        SELECT_PROMPT = "Ingrese selección:";
        PRODUCT_PROMPT = "¿Qué tipo de producto?";
        CANCEL_PROMPT = "presione enter para cancelar";
    }
}
