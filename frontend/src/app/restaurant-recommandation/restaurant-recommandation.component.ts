import { Component, OnInit } from '@angular/core';
import { Question } from '../dto/question';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserExpectations } from '../dto/user-expectations-dto';
import { RestaurantService } from '../service/restaurant.service';
import { RestaurantDto } from '../dto/restaurant-dto';
import { ConstantsService } from '../service/constants.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-restaurant-recommandation',
  templateUrl: './restaurant-recommandation.component.html',
  styleUrls: ['./restaurant-recommandation.component.css']
})
export class RestaurantRecommandationComponent implements OnInit {

  private questionsForm: FormGroup;
  private questions: Question[];
  private result: RestaurantDto;
  private showForm: boolean;
  private showResult: boolean;

  constructor(private builder: FormBuilder, private restaurantService: RestaurantService,
              private constants: ConstantsService, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.showForm = true;
    this.initializeQuestions();
    this.initializeForm();
  }

  onFormSubmit() {
    const dto: UserExpectations = this.getUserExpectationDTO();
    this.restaurantService.restaurantRecommandation(dto).subscribe(
      (response => {
        if (response !== null) {
          this.result = response;
          this.showForm = false;
          this.showResult = true;
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  goToDetails( id: number ) {
    localStorage.setItem('restaurantId', id.toString());
    this.showForm = false;
    this.showResult = false;
  }

  goBack() {
    this.showResult = false;
    this.showForm = true;
  }

  getUserExpectationDTO(): UserExpectations {
    const dto: UserExpectations = new UserExpectations();
    dto.company = this.questionsForm.controls.company.value;
    dto.occasion = this.questionsForm.controls.occasion.value;
    dto.onFoot = this.questionsForm.controls.onFoot.value;
    dto.price = this.questionsForm.controls.price.value;
    dto.kitchen = this.questionsForm.controls.kitchen.value;
    dto.tourist = this.questionsForm.controls.tourist.value;
    dto.numOfPeople = this.questionsForm.controls.numOfPeople.value;
    dto.music = this.questionsForm.controls.music.value;
    return dto;
  }


  initializeForm() {
    this.questionsForm = this.builder.group({
      company: ['', [Validators.required]],
      occasion: ['', [Validators.required]],
      onFoot: ['', [Validators.required]],
      price: ['', [Validators.required]],
      kitchen: [[], [Validators.required]],
      music: ['', [Validators.required]],
      numOfPeople: ['', [Validators.required]],
      age: ['', Validators.required],
      tourist: ['', Validators.required]
    });
    this.questionsForm.controls.kitchen.setValue('Whatever');
  }

  initializeQuestions() {
    this.questions = new Array<Question>();
    this.questions.push(new Question('company', 'Who are you going with?', ['Alone', 'Partner', 'Family', 'Friends', 'Colleagues']));
    this.questions.push(new Question('occasion', 'On what ocassion?', ['Special', 'No occasion']));
    this.questions.push(new Question('numOfPeople', 'Number of people?', []));
    this.questions.push(new Question('tourist', 'Are you a tourist?', ['Yes', 'No']));
    this.questions.push(new Question('onFoot', 'Will you go on foot?', ['Yes', 'No']));
    this.questions.push(new Question('price', 'What prices suit you?', ['Cheap', 'Affordable', 'Expensive', 'Unimportant']));
    this.questions.push(new Question('music', 'Music', ['Whatever', 'Classical', 'Folk', 'Pop', 'Jazz', 'Rock', 'Tamburitza']));
    this.questions.push(new Question('kitchen', 'Cuisine', ['Barbecue', 'European', 'Grill', 'Fusion', 'Central European',
                                                            'Mediterranean', 'Vegetarian Friendly', 'Vegan Options', 'Bar',
                                                             'International', 'Eastern European', 'Gluten Free Options', 'Japanese',
                                                              'Sushi', 'Central Asian', 'Thai', 'Fusion', 'Seafood', 'Asian',
                                                               'European', 'French', 'Deli', 'Italian', 'Latin', 'Spanish',
                                                                'Central American', 'Argentinean']));

  }

  getPicture(picture: string): string {
    return this.constants.localhost + picture;
  }

}
