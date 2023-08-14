package com.reaulou.sortvis;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Vector;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/selection-sort")
    public ResponseEntity<JSONObject> newEmployee(@RequestBody JSONObject request) {
        ArrayList<Integer> inputArray = (ArrayList<Integer>)request.get("inputArray");
        String sortAlgo = (String)request.get("sortingAlgo");

        //int arr[] = {3, 1, 15, 99, 57, 12, 27};
        //int arr[] = {3, 15, 1};
        int arr[] = inputArray.stream().mapToInt(i -> i).toArray();
        Vector<Integer> swaps = new Vector<Integer>();

        // sorter
        Sort sorter;
        switch (sortAlgo){
            case "Selection Sort":
                sorter = new SelectionSort();
                break;
            case "Bubble Sort":
                sorter = new BubbleSort();
                break;
            case "Insertion Sort":
                sorter = new InsertionSort();
                break;
            case "Quick Sort":
                sorter = new QuickSort();
                break;
            default: sorter = new SelectionSort();
        }


        sorter.sort(arr, swaps);
        sorter.printArray(arr);
        JSONObject response = new JSONObject();
        ArrayList<Integer> swapsList = new ArrayList<Integer>(swaps);
        response.put("swaps",swapsList);
        //return "9981" + request + "\n" + swaps;
        return ResponseEntity.ok(response);
    }

}