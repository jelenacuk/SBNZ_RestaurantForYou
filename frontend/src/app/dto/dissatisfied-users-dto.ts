import { ReportDTO } from './report-dto';
import { FeaturesDTO } from './features-dto';
import { UserDto } from './user-dto';
import { RestaurantDto } from './restaurant-dto';

export class DissatisfiedUserDto {

    user: UserDto;
    restaurants: RestaurantDto[];

}
