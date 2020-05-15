import { Component, OnInit } from '@angular/core';
import { Question } from '../dto/question';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserExpectations } from '../dto/user-expectations-dto';

@Component({
  selector: 'app-restaurant-recommandation',
  templateUrl: './restaurant-recommandation.component.html',
  styleUrls: ['./restaurant-recommandation.component.css']
})
export class RestaurantRecommandationComponent implements OnInit {

  private questionsForm: FormGroup;
  private questions1: Question[];
  private questions2: Question[];

  constructor(private builder: FormBuilder) { }

  ngOnInit() {

    this.initializeQuestions();
    this.initializeForm();
  }

  onFormSubmit() {
    const dto: UserExpectations = this.getUserExpectationDTO();
    console.log(JSON.stringify(dto));
  }

  getUserExpectationDTO(): UserExpectations {
    const dto: UserExpectations = new UserExpectations();
    dto.company = this.questionsForm.controls.company.value;
    dto.occasion = this.questionsForm.controls.occasion.value;
    dto.when = this.questionsForm.controls.when.value;
    dto.hungry = this.questionsForm.controls.hungry.value;
    dto.mood = this.questionsForm.controls.mood.value;
    dto.transport = this.questionsForm.controls.transport.value;
    dto.price = this.questionsForm.controls.price.value;
    dto.kitchen = this.questionsForm.controls.kitchen.value;
    dto.music = this.questionsForm.controls.music.value;
    dto.ambience = this.questionsForm.controls.ambience.value;
    dto.numOfPeople = this.questionsForm.controls.numOfPeople.value;
    return dto;
  }


  initializeForm() {
    this.questionsForm = this.builder.group({
      company: ['', [Validators.required]],
      occasion: ['', [Validators.required]],
      when: ['', [Validators.required]],
      transport: ['', [Validators.required]],
      mood: ['', [Validators.required]],
      price: ['', [Validators.required]],
      hungry: ['', [Validators.required]],
      kitchen: ['', [Validators.required]],
      ambience: ['', [Validators.required]],
      music: ['', [Validators.required]],
      numOfPeople: ['', [Validators.required]]
    });
    this.questionsForm.controls.kitchen.setValue('Whatever');
    this.questionsForm.controls.ambience.setValue('Whatever');
    this.questionsForm.controls.music.setValue('Whatever');
  }

  initializeQuestions() {
    this.questions1 = new Array<Question>();
    this.questions1.push(new Question('company', 'Who are you going with?', ['Alone', 'Partner', 'Family', 'Friends', 'Colleagues']));
    this.questions1.push(new Question('occasion', 'On what ocassion?', ['Celebration', 'Romance', 'Business', 'No special reason']));
    this.questions1.push(new Question('numOfPeople', 'Number of people?', []));
    this.questions1.push(new Question('when', 'When?', ['Right now', 'Later']));
    this.questions1.push(new Question('hungry', 'How much hungry you are?', ['Starving', 'Still not critical']));
    this.questions1.push(new Question('mood', 'What mood are you in?', ['Tired', 'Cheerful', 'Curious', 'Nervous']));
    this.questions1.push(new Question('transport', 'Will you go on foot?', ['Yes', 'No']));
    this.questions1.push(new Question('price', 'What prices suit you?', ['Cheap', 'Medium', 'Expensive', 'Unimportant']));

    this.questions2 = new Array<Question>();
    this.questions2.push(new Question('kitchen', 'Kitchen', ['Whatever', 'Local', 'Chinese', 'Italian', 'Fish', 'Fast food']));
    this.questions2.push(new Question('ambience', 'Ambience', ['Whatever', 'Traditional', 'Homly',
                                                                'Classic', 'Modern', 'Artistic', 'Creative']));
    this.questions2.push(new Question('music', 'Music', ['Whatever', 'Classic', 'Foreign', 'Live', 'Pop', 'Jazz', 'Tamburitza', 'Local']));
  }

}
