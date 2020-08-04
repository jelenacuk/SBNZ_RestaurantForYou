import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { AddRestaurantDto } from 'src/app/dto/add-restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { FeaturesDTO } from 'src/app/dto/features-dto';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent implements OnInit {

  private addRestauratForm: FormGroup;
  private priceValues: string[] = new Array<string>();
  private capacityValues: string[] = new Array<string>();
  private kitchenValues: string[] = new Array<string>();
  private musicValues: string[] = new Array<string>();
  private ambienceValues: string[] = new Array<string>();

  private path: string;
  private restaurantDto: AddRestaurantDto = new AddRestaurantDto();

  constructor(private formBuilder: FormBuilder, private restaurantService: RestaurantService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.path = '../../assets/images/default.jpg';
    this.initializeCollectionValues();
    this.buildForm();

  }


  onAddRestaurantSubmit() {
    this.restaurantData();
    this.restaurantService.addRestaurantd(this.restaurantDto).subscribe(
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

  openInput() {
    document.getElementById('fileInput').click();
  }
  uploadPhoto(files) {
    const file = files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.path = reader.result.toString();
    };
    reader.onerror = error => {
      console.log('Error: ', error);
    };
  }



  restaurantData() {
    this.restaurantDto.name = this.addRestauratForm.controls.name.value;
    this.restaurantDto.description = this.addRestauratForm.controls.description.value;
    this.restaurantDto.street = this.addRestauratForm.controls.street.value;
    this.restaurantDto.number = this.addRestauratForm.controls.number.value;
    this.restaurantDto.latitude = this.addRestauratForm.controls.latitude.value;
    this.restaurantDto.longitude = this.addRestauratForm.controls.longitude.value;
    this.restaurantDto.capacity = this.addRestauratForm.controls.capacity.value;
    this.restaurantDto.kitchen = this.addRestauratForm.controls.kitchen.value;
    this.restaurantDto.ambience = this.addRestauratForm.controls.ambience.value;
    this.restaurantDto.music = this.addRestauratForm.controls.music.value;
    this.restaurantDto.price = this.addRestauratForm.controls.price.value;
    this.restaurantDto.image = this.path;

    this.restaurantDto.features = new FeaturesDTO();

    this.restaurantDto.features.outdoorSeating = this.addRestauratForm.controls.garden.value;
    this.restaurantDto.features.alcohol = this.addRestauratForm.controls.wine.value;
    this.restaurantDto.features.programForChiledern = this.addRestauratForm.controls.childern.value;
    this.restaurantDto.features.liveMusic = this.addRestauratForm.controls.liveMusic.value;
    this.restaurantDto.features.reservations = this.addRestauratForm.controls.reservations.value;
    this.restaurantDto.features.parking = this.addRestauratForm.controls.parking.value;
    this.restaurantDto.features.wifi = this.addRestauratForm.controls.wifi.value;
    this.restaurantDto.features.tv = this.addRestauratForm.controls.tv.value;
  }

  buildForm() {
    this.addRestauratForm = this.formBuilder.group({
      name: ['', [
        Validators.required,
        Validators.minLength(2),
        Validators.pattern('[a-z A-Z 0-9]*')
      ]],
      description: ['', [
        Validators.required
      ]],
      street: ['', [
        Validators.required,
        Validators.pattern('[a-z A-Z 0-9]*')
      ]],
      number: ['', [
        Validators.required,
      ]],
      latitude: ['', [
        Validators.required,
        Validators.pattern('[0-9]*,?[0-9]*')
      ]],
      longitude: ['', [
        Validators.required,
        Validators.pattern('[0-9]*,?[0-9]*')
      ]],
      capacity: ['', [
        Validators.required
      ]],
      price: ['', [
        Validators.required
      ]],
      music: ['', [
        Validators.required
      ]],
      ambience: ['', [
        Validators.required
      ]],
      kitchen: ['', [
        Validators.required
      ]],
      wine: ['', [
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

    this.kitchenValues.push('Local');
    this.kitchenValues.push('Italian');
    this.kitchenValues.push('Chinese');
    this.kitchenValues.push('Fast food');
    this.kitchenValues.push('Fish');

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
