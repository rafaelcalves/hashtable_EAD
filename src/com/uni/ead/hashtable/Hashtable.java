package com.uni.ead.hashtable;

public interface Hashtable<V> {

    /**
     * Remove o objeto com.uni.ead.hashtable.Item de chave key na lista encadeada. Retorna o com.uni.ead.hashtable.Item removido.
     *
     * @param key - chave do objeto com.uni.ead.hashtable.Item que sera removido da hashtable
     * @return o item que foi deletado ou null caso nao exista um com.uni.ead.hashtable.Item com a key
     * recebida como parametro
     */

    public Item<V> delete (int key);

    /**
     * Insere um objeto com.uni.ead.hashtable.Item na hashtable.
     * @param item - Objeto com.uni.ead.hashtable.Item, instanciado previamente (contem uma key (K) e
     * um value (V))
     * @return a posicao do objeto na hashtable
     */

    public int insert (Item<V> item);

    /**
     * Busca o objeto com.uni.ead.hashtable.Item de chave key na hashtable.
     *
     * @param key - chave do objeto com.uni.ead.hashtable.Item que sera pesquisada na hashtable
     * @return um objeto com.uni.ead.hashtable.Item que tem a key igual a key recebida como parametro
     * ou null caso nao exista tal objeto na hashtable
     */

    public Item<V> search (int key);

    /**
     * Exibe na tela o conteúdo da hashtable no formato (posicao) valor1, valor2, valor3,
     */

    public void print ();
}