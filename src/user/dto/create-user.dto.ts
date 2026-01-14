import { IsEmail, isEmail, IsNotEmpty, MinLength } from "class-validator"

export class CreateUserDTO {

    @MinLength(3)
    @IsNotEmpty()
    username: string

    @IsEmail()
    @IsNotEmpty()
    email: string

    @MinLength(8)
    @IsNotEmpty()
    password: string
}