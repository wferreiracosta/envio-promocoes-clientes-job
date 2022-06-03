package br.com.wferreiracosta.enviopromocoesclientes.domains;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InteresseProdutoCliente {

    private Cliente cliente;
    private Produto produto;

}
