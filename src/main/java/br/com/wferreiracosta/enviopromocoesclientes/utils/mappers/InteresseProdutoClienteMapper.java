package br.com.wferreiracosta.enviopromocoesclientes.utils.mappers;

import br.com.wferreiracosta.enviopromocoesclientes.domains.Cliente;
import br.com.wferreiracosta.enviopromocoesclientes.domains.InteresseProdutoCliente;
import br.com.wferreiracosta.enviopromocoesclientes.domains.Produto;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class InteresseProdutoClienteMapper {

    public static InteresseProdutoCliente map(Produto produto, Cliente cliente) {
        return InteresseProdutoCliente.builder()
                .produto(produto)
                .cliente(cliente)
                .build();
    }

}
