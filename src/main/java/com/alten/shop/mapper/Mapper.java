package com.alten.shop.mapper;

/**
 * Interface pour mapper un objet de type A vers un objet de type B
 * @author antonio
 *
 * @param <A>
 * @param <B>
 */
public interface Mapper<A , B>  {
   
   /**
    * Methode pour mapper un objet de type A vers un objet de type B 	
    * @param object
    * @return
    */
   B toDoMapping(A object);
}
