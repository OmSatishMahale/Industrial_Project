package com.marvellous.MarvellousFullStack.Service;

import com.marvellous.MarvellousFullStack.Entity.BatchEntry;
import com.marvellous.MarvellousFullStack.Repository.BatchEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BatchEntryService {
    @Autowired
    private BatchEntryRepository batchEntryRepository;

    //Create : Post
    public void saveEntry(BatchEntry batchEntry)
    {
            batchEntryRepository.save(batchEntry);
    }

    //Read : Get
    public List<BatchEntry> getAll() {
        return batchEntryRepository.findAll();
    }

    //read : GET
    public Optional<BatchEntry> findById(ObjectId id) {
        return batchEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id)
    {
        batchEntryRepository.deleteById(id);
    }
}
