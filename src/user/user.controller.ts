import { Body, Controller, Get, Param, Post } from '@nestjs/common';
import { CreateUserDTO } from './dto/create-user.dto';
import { UserService } from './user.service';

@Controller('user')
export class UserController {
    constructor(private readonly userService: UserService) {}

    @Get()
    async listAll() {
        return await this.userService.listAll()
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.userService.findOne(id)
    }

    @Post()
    async create(@Body() body: CreateUserDTO) {
        return await this.userService.createUser(body)
    }
}
