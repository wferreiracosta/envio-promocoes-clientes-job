package br.com.wferreiracosta.enviopromocoesclientes.utils.queries;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class InteresseProdutoClienteQuery {

    public static final String FIND_INTERESSE_PRODUTO_CLIENTE = "SELECT interesse_produto_cliente.cliente as 'interesse_produto_cliente_cliente'," +
            " interesse_produto_cliente.produto as 'interesse_produto_cliente_produto'," +
            " cliente.id as 'cliente_id', cliente.nome as 'cliente_nome', cliente.email as 'cliente_email'," +
            " produto.id as 'produto_id', produto.nome as 'produto_nome', produto.descricao as 'produto_descricao', produto.preco as 'produto_preco'" +
            " FROM envio_promocoes_clientes.interesse_produto_cliente" +
            " join cliente on (cliente.id = cliente)" +
            " join produto on (produto.id = produto);";

}
