import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { AddRestaurantDto } from 'src/app/dto/add-restaurant-dto';

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
  constructor(private formBuilder: FormBuilder) { }

  private path: string;
  private workingDays: boolean;
  private restaurantDto: AddRestaurantDto = new AddRestaurantDto();

  ngOnInit() {
    this.path = '../../assets/images/default.jpg';
    this.workingDays = false;
    this.initializeCollectionValues();
    this.buildForm();

  }

  goToWorkingDays() {
    this.restaurantData();
    this.workingDays = true;
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
    this.restaurantDto.garden = this.addRestauratForm.controls.garden.value;
    this.restaurantDto.wideRangeOfWines = this.addRestauratForm.controls.wine.value;
    this.restaurantDto.programForChildern = this.addRestauratForm.controls.childern.value;
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
    this.kitchenValues.push('Healthy');
    this.kitchenValues.push('Fish');

    this.musicValues.push('Classic');
    this.musicValues.push('Foreign');
    this.musicValues.push('Live');
    this.musicValues.push('Pop');
    this.musicValues.push('Jazz');
    this.musicValues.push('Old town');
    this.musicValues.push('Tamburitza');

    this.ambienceValues.push('Traditionaly');
    this.ambienceValues.push('Homly');
    this.ambienceValues.push('Classic');
    this.ambienceValues.push('Modern');
    this.ambienceValues.push('Creative');
    this.ambienceValues.push('Artistic');
  }

}
