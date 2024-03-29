
import { FeaturesDTO } from './features-dto';

export class AddRestaurantDto {

    name: string;
    description: string;
    image: string;
    capacity: string;
    kitchen: string;
    music: string;
    ambience: string;
    programForChildern: boolean;
    garden: boolean;
    wideRangeOfWines: boolean;
    price: string;
    street: string;
    number: string;
    latitude: number;
    longitude: number;
    features: FeaturesDTO;

}
