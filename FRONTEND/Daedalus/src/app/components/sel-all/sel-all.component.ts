import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/material/stepper';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProductsService } from 'src/app/services/products.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-sel-all',
    templateUrl: './sel-all.component.html',
    styleUrls: ['./sel-all.component.scss']
})
export class SelAllComponent implements OnInit {

    // STEP 1 - ALL
    chosenOption!: string;
    options: string[] = ["Cooking", "Cleaning", "Washing"];

    ///////////////////////

    // STEP 2 - cooking
    // chosenOption1!: string;
    // options1: string[] = ["Cooking regularly", ""];

    // STEP 3 - cooking regularly
    // chosenOption1_1!: string;
    // options1_1: string[] = ["", "", ""];

    ///////////////////////

    // STEP 2 - cleaning
    // chosenOption2!: string;
    // options2: string[] = ["", ""];

    // STEP 3 -
    // chosenOption2_1!: string;
    // options2_1: string[] = ["", "", ""];

    ///////////////////////

    // STEP 2 - washing
    chosenOption3!: string;
    options3: string[] = ["Washing dishes", "Washing clothes"];
    optionToFilter3!: string

    // STEP 3 - washing dishes
    chosenOption3_1!: string;
    options3_1: string[] = ["Dishwashers are too expensive", "I don't have enough space for one", "I don't have permission to install one"];
    optionToFilter3_1!: string

    // STEP 3 - washing clothes
    // chosenOption3_2!: string;
    // options3_2: string[] = ["Washing machines are too expensive", "I don't have enough space for one", "I don't have permission to install one"];

    ///////////////////////

    firstFormGroup = this._formBuilder.group({
        firstCtrl: ["", Validators.required],
    });
    secondFormGroup = this._formBuilder.group({
        // secondCtrl: "",
        secondCtrl: ["", Validators.required],
    });
    thirdFormGroup = this._formBuilder.group({
        thirdCtrl: ["", Validators.required],
    });
    stepperOrientation: Observable<StepperOrientation>;

    filteredProductsStep1: any
    filteredProductsStep2: any
    filteredProductsStep3: any

    constructor(private productService: ProductsService, private router: Router, private _formBuilder: FormBuilder, breakpointObserver: BreakpointObserver) {
        this.stepperOrientation = breakpointObserver
            .observe("(min-width: 800px)")
            .pipe(map(({ matches }) => (matches ? "horizontal" : "vertical")));
    }

    ngOnInit(): void {
    }

    filterStep1() {
        this.productService.getProductByCategory(this.chosenOption).subscribe(data => {
            this.filteredProductsStep1 = data
            console.log(this.filteredProductsStep1);
        })
    }

    filterStep2() {
        switch (this.chosenOption3) {
            case "Washing dishes":
                this.optionToFilter3 = "Dishwashing"
                break;

            case "Washing clothes":
                this.optionToFilter3 = "Clothes"
                break;
            default:
        }

        this.productService.getProductByCategory(this.optionToFilter3).subscribe(data => {
            this.filteredProductsStep2 = data

            let temp: any[] = []
            for (let i = 0; i < this.filteredProductsStep1.length; i++) {
                for (let j = 0; j < this.filteredProductsStep2.length; j++) {
                    if (this.filteredProductsStep1[i].id == this.filteredProductsStep2[j].id) {
                        temp.push(this.filteredProductsStep1[i])
                    }
                }
            }
            this.filteredProductsStep2 = temp
        })
    }

    filterStep3() {
        switch (this.chosenOption3_1) {
            case "Dishwashers are too expensive":
                this.optionToFilter3_1 = "Cheap"
                break;

            case "I don't have enough space for one":
                this.optionToFilter3_1 = "Portable"
                break;

            case "I don't have permission to install one":
                this.optionToFilter3_1 = "Faucet compatible"
                break;

            default:
        }

        this.productService.getProductByCategory(this.optionToFilter3_1).subscribe(data => {
            this.filteredProductsStep3 = data

            let temp: any[] = []
            for (let i = 0; i < this.filteredProductsStep2.length; i++) {
                for (let j = 0; j < this.filteredProductsStep3.length; j++) {
                    if (this.filteredProductsStep2[i].id == this.filteredProductsStep3[j].id) {
                        temp.push(this.filteredProductsStep2[i])
                    }
                }
            }
            this.filteredProductsStep3 = temp
        })
    }

    goToSolutions() {
        this.productService.selection = this.filteredProductsStep3
        this.router.navigate(["/selection/products"])
    }

}
