package br.com.wferreiracosta.enviopromocoesclientes.domains;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private int id;
    private String nome;
    private String email;

}
