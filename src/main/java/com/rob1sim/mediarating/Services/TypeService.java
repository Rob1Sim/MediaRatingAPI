package com.rob1sim.mediarating.Services;

import com.rob1sim.mediarating.Entity.Type;
import com.rob1sim.mediarating.Repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    private final TypeRepository typeRepository;
    @Autowired
    public TypeService(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }
    public Type save(Type type){
        return typeRepository.save(type);
    }
}
