import { Body, Controller, Delete, Get, Param, Patch, Post, Query } from '@nestjs/common';
import { CreateUserDTO } from './dto/create-user.dto';
import { UserService } from './user.service';
import { UpdateUserDTO } from './dto/update-user.dto';
import { PaginationDTO } from 'src/common/dto/pagination.dto';

@Controller('user')
export class UserController {
    constructor(private readonly userService: UserService) {}

    @Get()
    async listAll(@Query() paginationDTO: PaginationDTO) {
        return await this.userService.listAll(paginationDTO)
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.userService.findOne(id)
    }

    @Post()
    async create(@Body() body: CreateUserDTO) {
        return await this.userService.createUser(body)
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() body: UpdateUserDTO) {
        return await this.userService.updateUser(id, body)
    }

    @Delete(':id')
    async delete(@Param('id') id: string) {
        return await this.userService.deleteUser(id)
    }
}
