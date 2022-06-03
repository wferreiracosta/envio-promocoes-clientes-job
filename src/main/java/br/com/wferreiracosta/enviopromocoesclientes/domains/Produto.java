package br.com.wferreiracosta.enviopromocoesclientes.domains;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private Double preco;

}
