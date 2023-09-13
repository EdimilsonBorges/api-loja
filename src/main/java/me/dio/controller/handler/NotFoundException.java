package me.dio.controller.handler;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensagem){
        super(mensagem);

    }

    public NotFoundException(String mensagem, Object ...params){
        super(String.format(mensagem,params));

    }
}
