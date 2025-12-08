package com.marvellous.MarvellousFullStack.Controller;

import com.marvellous.MarvellousFullStack.Entity.BatchEntry;
import com.marvellous.MarvellousFullStack.Service.BatchEntryService;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    @Autowired
    private BatchEntryService batchEntryService;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        List<BatchEntry> allData = batchEntryService.getAll();

        if(allData != null && !allData.isEmpty())
        {
            return new ResponseEntity<>(allData, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BatchEntry> createEntry(@RequestBody BatchEntry myentry)
    {
        try
        {
            batchEntryService.saveEntry(myentry);
            return new ResponseEntity<BatchEntry>(myentry, HttpStatus.CREATED);
        }
        catch(Exception E)
        {
            return new ResponseEntity<BatchEntry>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myid)
    {
        batchEntryService.deleteById(myid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
