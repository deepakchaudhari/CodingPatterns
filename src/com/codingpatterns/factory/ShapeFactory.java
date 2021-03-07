package com.codingpatterns.factory;

public class ShapeFactory {

  //ublic PolyGon getShapeWithSide(int sides){

    int size;

    static PolyGon getShape(int size){

    if(size ==  3){
      return new Traingle();
    }

    else if(size == 4 ){
      return new Square();
    }

    else if(size == 5){
      return new Pentagone();
    }
    else{
      return null;
    }

/**
 *
 * traingle
 *
 *
 */





  }

}
