package com.erudia.demo.controller;


import com.erudia.demo.connector.*;

import java.util.HashMap;

import javax.annotation.Generated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/requisitar")
public class RequisicaoResource {

    private IndexMannager mIndexBuscar = new IndexMannager(7000, 11);
    private IndexMannager mIndexBuscarMaisPopulares = new IndexMannager(7100, 11);
    private IndexMannager mIndexRecomendacao = new IndexMannager(7200, 11);
    private IndexMannager mIndexRetorneSugestao = new IndexMannager(7300, 11);
    private IndexMannager mTeste = new IndexMannager(7600,11);

  //  String resp = JythonComunication.SendToPython(mIndex, fala);
                                                                        //Preço e Qtd de Vizualização
    @GetMapping("/busca/{pesquisa}/{categoria}/{idCliente}/{valormin}/{valormax}/{ordenacao}") // 'menor_preco', 'maior_preco','popularidade'
    public String buscar(@PathVariable String pesquisa, @PathVariable String categoria, @PathVariable String idCliente , @PathVariable String valormin, @PathVariable String valormax, @PathVariable String ordenacao ) {
        //TODO Parsear Categoria 
        //String entradaDaBusca = "camisa,masculina|moderna|nike,0,2,DESC"
        String entradaDaBusca = pesquisa  + "," + categoria + "," + idCliente + ","  +  valormax  + "," + valormin  + "," + ordenacao;
//        String resp = JythonComunication.SendToPython(mIndexBuscar, entradaDaBusca);
        HashMap<String, Object> map = new HashMap<>();
        return "[2,3,6,8,10,12,14,15,18,21,22,28,32,45]";
    }

    @GetMapping("/maispop/{numeroProdutos}")//devolve recomendação pagina inicial
    public String buscarMaisPopulares(@PathVariable int numeroProdutos) {
  //      String respostaDosPopulares = JythonComunication.SendToPython(mIndexBuscarMaisPopulares, "");
        HashMap<String, Object> map = new HashMap<>();
        return "[4,5,6,7,8,10,14,16,20,23,26,27,34,45]";
    }

    @GetMapping("/bucarrelacionado/{idCliente}/{numeroProdutos}") //devolve 5 itens
    public String recomendacaoDadoProduto(@PathVariable int idCliente, @PathVariable int numeroProdutos) {
    //    String recomendacaoParaCliente = JythonComunication.SendToPython(mIndexRecomendacao, "" + idCliente + "," + idProduto);
        return "[1,2,3,5,6,9,10,12,13,17,19,21,32,45]";
    }

    @GetMapping("/retornesugestao/{busca}")// sugestão, de complemento lista de strings 
    public String retorneSugestoes(@PathVariable String  busca) {
        String recomendacaoParaCliente = JythonComunication.SendToPython(mIndexRetorneSugestao, busca);
        return "[camiseta, camisa]";
    }

    private HashMap<String,Object> montar(String p) {
        return null;
    }

    @GetMapping("/maispop/testePop")
    public String buscarMaisPopularesTeste() {
        String respostaDosPopulares = JythonComunication.SendToPython(mTeste, "");
        HashMap<String, Object> map = new HashMap<>();
        return respostaDosPopulares;
    }
    

    // @GetMapping("/busca/{pesquisa}/{categoria}/{idCliente}/{valormin}/{valormax}/{ordenacao}")
    // public HashMap<String, Object> buscar(@PathVariable String pesquisa, @PathVariable String categoria, @PathVariable String idCliente , @PathVariable String valormin, @PathVariable String valormax, @PathVariable String ordenacao ) {
    //     //TODO Parsear Categoria 
    //     //String entradaDaBusca = "camisa,masculina|moderna|nike,0,2,DESC"
    //     String entradaDaBusca = pesquisa  + "," + categoria + "," + idCliente + ","  +  valormax  + "," + valormin  + "," + ordenacao;
    //     String resp = JythonComunication.SendToPython(mIndexBuscar, entradaDaBusca);
    //     HashMap<String, Object> map = new HashMap<>();
    //     return null;
    // }

    // @GetMapping("/maispop")
    // public HashMap<String, Object> buscarMaisPopulares() {
    //     String respostaDosPopulares = JythonComunication.SendToPython(mIndexBuscarMaisPopulares, "");
    //     HashMap<String, Object> map = new HashMap<>();
    //     return null;
    // }

    // @GetMapping("/bucarrelacionado/{idCliente}/{idProduto}")
    // public HashMap<String, Object> recomendacaoDadoProduto(@PathVariable int idCliente, @PathVariable int idProduto) {
    //     String recomendacaoParaCliente = JythonComunication.SendToPython(mIndexRecomendacao, "" + idCliente + "," + idProduto);
    //     return null;
    // }


}
