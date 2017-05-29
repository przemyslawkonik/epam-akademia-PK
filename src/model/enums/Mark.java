package model.enums;

import main.Main;

/**
 * Created by Przemysław Konik on 2017-05-29.
 */
public enum Mark {
   O("O"),
    X("X"),
   EMPTY("-");

   private String mark;

   private Mark(String mark) {
       this.mark = mark;
   }


   @Override
    public String toString() {
       return mark;
   }
}
