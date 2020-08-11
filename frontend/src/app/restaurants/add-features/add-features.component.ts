import { Component, OnInit } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { MatSnackBar } from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FeaturesDTO } from 'src/app/dto/features-dto';

@Component({
  selector: 'app-add-features',
  templateUrl: './add-features.component.html',
  styleUrls: ['./add-features.component.css']
})
export class AddFeaturesComponent implements OnInit {

  private restaurantId: number;
  private restaurant: RestaurantDto;
  private addFeaturesForm: FormGroup;
  private priceValues: string[] = new Array<string>();
  private capacityValues: string[] = new Array<string>();
  private musicValues: string[] = new Array<string>();
  private ambienceValues: string[] = new Array<string>();

  constructor( private restaurantService: RestaurantService, private snackBar: MatSnackBar, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.restaurantId = Number(localStorage.getItem('featuresId'));
    this.getRestaurant();
    this.initializeCollectionValues();
    this.buildForm();
  }

  getRestaurant() {
    this.restaurantService.getRestaurantById(this.restaurantId).subscribe(
      (response => {
        this.restaurant = response;
      }),
       (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  onAddRestaurantSubmit() {
    this.featuresData();
    this.restaurantService.updateRestaurant(this.restaurant).subscribe(
      (response => {
        if (response === true) {
          this.snackBar.open('Successfuly!');
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  featuresData() {
    this.restaurant.features = new FeaturesDTO();
    this.restaurant.features.capacity = this.addFeaturesForm.controls.capacity.value;
    this.restaurant.features.ambience = this.addFeaturesForm.controls.ambience.value;
    this.restaurant.features.music = this.addFeaturesForm.controls.music.value;
    this.restaurant.features.price = this.addFeaturesForm.controls.price.value;
    this.restaurant.price = this.addFeaturesForm.controls.price.value;
    this.restaurant.features.outdoorSeating = this.addFeaturesForm.controls.garden.value;
    this.restaurant.features.alcohol = this.addFeaturesForm.controls.alcohol.value;
    this.restaurant.features.programForChiledern = this.addFeaturesForm.controls.childern.value;
    this.restaurant.features.liveMusic = this.addFeaturesForm.controls.liveMusic.value;
    this.restaurant.features.reservations = this.addFeaturesForm.controls.reservations.value;
    this.restaurant.features.parking = this.addFeaturesForm.controls.parking.value;
    this.restaurant.features.wifi = this.addFeaturesForm.controls.wifi.value;
    this.restaurant.features.tv = this.addFeaturesForm.controls.tv.value;
  }

  buildForm() {
    this.addFeaturesForm = this.formBuilder.group({
      price: ['', [
        Validators.required
      ]],
      music: [[], [
        Validators.required
      ]],
      ambience: [[], [
        Validators.required
      ]],
      capacity: ['', [
        Validators.required
      ]],
      alcohol: ['', [
      ]],
      childern: ['', [
      ]],
      garden: ['', [
      ]],
      liveMusic: ['', [
      ]],
      reservations: ['', [
      ]],
      parking: ['', [
      ]],
      wifi: ['', [
      ]],
      tv: ['', [
      ]]
    });
  }

  initializeCollectionValues() {
    this.priceValues.push('Cheap');
    this.priceValues.push('Affordable');
    this.priceValues.push('Expensive');

    this.capacityValues.push('Small');
    this.capacityValues.push('Medium');
    this.capacityValues.push('Large');


    this.musicValues.push('Classical');
    this.musicValues.push('Folk');
    this.musicValues.push('Pop');
    this.musicValues.push('Jazz');
    this.musicValues.push('Rock');
    this.musicValues.push('Tamburitza');

    this.ambienceValues.push('Traditional');
    this.ambienceValues.push('Relaxed');
    this.ambienceValues.push('Romantic');
    this.ambienceValues.push('Creative');
    this.ambienceValues.push('Luxurious');
  }

}
