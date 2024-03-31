package com.valentyn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientDTO, Long> {
    // Здесь можно добавить дополнительные методы для работы с клиентами, если это необходимо
}
