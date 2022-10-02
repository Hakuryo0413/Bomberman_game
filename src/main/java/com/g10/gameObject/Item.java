package com.g10.gameObject;

import com.g10.general.ImageManager;

public class Item extends VisibleObject {
        private ItemType type;

        public Item(ItemType type, int x, int y){
            super(null, x,y,width, height);
            switch (type){
                case BOM_UP -> super(ImageManager.getImage(""), x,y,width, height);

            }
        }


}
