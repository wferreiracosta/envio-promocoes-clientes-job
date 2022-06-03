package br.com.wferreiracosta.enviopromocoesclientes.utils.mappers;

import br.com.wferreiracosta.enviopromocoesclientes.domains.Cliente;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ClienteMapper {

    public static Cliente map(ResultSet rs) throws SQLException {
        return Cliente.builder()
                .id(rs.getInt("cliente_id"))
                .nome(rs.getString("cliente_nome"))
                .email(rs.getString("cliente_email"))
                .build();
    }

}
