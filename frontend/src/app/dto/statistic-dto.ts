import { ReportDTO } from './report-dto';
import { DissatisfiedUserDto } from './dissatisfied-users-dto';
import { RestaurantDto } from './restaurant-dto';

export class StatisticDto {

    mostRecommended: RestaurantDto;
    leastRecommended: RestaurantDto;
    dissatisfiedUsers: DissatisfiedUserDto[];

}
